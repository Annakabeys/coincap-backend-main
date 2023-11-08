package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import scala.concurrent.{ExecutionContext, Future}
import models.domain.AssetList
import play.api.libs.json._
import play.api.libs.ws.WSClient
import models.repo.PortfolioRepo
import models.domain.Portfolio
import play.api.data._
import play.api.data.Forms._
import play.api.data.format.Formats._
import java.util.UUID
import play.api.i18n.I18nSupport

@Singleton
class HomeController @Inject()(
  val portfolioRepo: PortfolioRepo,
  val controllerComponents: ControllerComponents, 
  ws: WSClient,
  implicit val ec: ExecutionContext
  ) extends BaseController with I18nSupport {

  val portfolioForm: Form[Portfolio] = Form(
    mapping(
      "id" -> ignored(UUID.randomUUID()),
      "name" -> nonEmptyText,
      "holdings" -> nonEmptyText,
      "quantity" -> bigDecimal
    )(Portfolio.apply)(Portfolio.unapply)
  )

  val editPortfolioNameForm = Form(
    single(
      "name" -> nonEmptyText
    )
  )

  // def assets() = Action.async { implicit request =>
  //   implicit val reads: Reads[AssetList] = Json.reads[AssetList]
  //   val url = "https://api.coincap.io/v2/assets"
  //   ws.url(url).get().map { response =>
  //     val assets = (response.json \ "data").as[Seq[AssetList]]
  //     assets.foreach { asset =>
  //       AssetList.asset += AssetList(asset.name.capitalize, "", "", "")
  //     }
  //     Ok(Json.toJson(assets))
  //   }
  // }

  // def index() = Action.async { implicit request: Request[AnyContent] =>
  //   portfolioRepo.createPortfolioTable.map { _ => Ok("Portfolio table created")}
  // }

  def index() = Action.async { implicit request =>
    implicit val reads: Reads[AssetList] = Json.reads[AssetList]
    val url = "https://api.coincap.io/v2/assets"
    val createTableFuture = portfolioRepo.createPortfolioTable

    val apiDataFuture = ws.url(url).get().map { response =>
      val assets = (response.json \ "data").as[Seq[AssetList]]
      assets.foreach { asset =>
        AssetList.asset += AssetList(asset.name.capitalize, "", "", "")  
      }  
      Ok(Json.toJson(assets))
    }

    for {
      _ <- createTableFuture
      response <- apiDataFuture
    } yield response
  }

  def getAll = Action.async { implicit request: Request[AnyContent] =>
    portfolioRepo.getAllPortfolios.map { portfolios => Ok(Json.toJson(portfolios))}
  }

  def addPortfolio() = Action.async { implicit request =>
    portfolioForm.bindFromRequest().fold(
      formWithErrors => {
        Future.successful(BadRequest)
      },
      portfolio => {
        portfolioRepo.insert(
          portfolio.copy(id = UUID.randomUUID())
        ).map { _ => Ok("Portfolio added")}
      }
    )
  }

  // def editPortfolioName(id: String, newName: String) = Action.async { implicit request => 
  //   portfolioRepo.updatePortfolioName(UUID.fromString(id), newName).map( _ => Ok("Portfolio name updated"))
  // }

  def editPortfolioName(id: String) = Action.async { implicit request => 
    editPortfolioNameForm.bindFromRequest().fold(
      formWithErrors => {
        Future.successful(BadRequest)
      },
      newName => {
        portfolioRepo.updatePortfolioName(UUID.fromString(id), newName
        ).map { _ => Ok("Portfolio name updated")}
      }
    )
  }

  def deletePortfolio(id: String) = Action.async { implicit request =>
    portfolioRepo.deletePortfolio(UUID.fromString(id)).map { _ => Ok("Portfolio deleted")}
  } 
}
