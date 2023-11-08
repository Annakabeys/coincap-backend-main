file://<WORKSPACE>/app/controllers/HomeController.scala
### java.lang.IndexOutOfBoundsException: 1

occurred in the presentation compiler.

action parameters:
offset: 721
uri: file://<WORKSPACE>/app/controllers/HomeController.scala
text:
```scala
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

@Singleton
class HomeController @Inject()(
  val portfolioRepo: PortfolioRepo,
  val controllerComponents: ControllerComponents, 
  ws: WSClient,
  implicit val ec: ExecutionContext
  ) extends BaseController {

  val portfolioForm: Form[Portfolio] = (
    mapping (
      "id" -> ignored(UUID.randomUUID()),
      "name" -> nonEmptyText,
      "holdings" -> list(nonEmptyText),
      "quantity" -> numeric
    )(Portfolio.apply)(@@)
  )

  def assets() = Action.async { implicit request => 
    implicit val reads: Reads[AssetList] = Json.reads[AssetList]
    val url = "https://api.coincap.io/v2/assets"
    ws.url(url).get().map { response => 
      val assets = (response.json \ "data").as[Seq[AssetList]]
      assets.foreach { asset =>
        AssetList.asset += AssetList(asset.name.capitalize, "")  
      }  
      Ok(Json.toJson(assets))
    }
  }

  def index() = Action.async { implicit request: Request[AnyContent] =>
    portfolioRepo.createPortfolioTable.map { _ => Ok("Portfolio table created")}
  }
}

```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.countParams(Signatures.scala:501)
	dotty.tools.dotc.util.Signatures$.countParams(Signatures.scala:501)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:186)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:94)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:63)
	scala.meta.internal.pc.MetalsSignatures$.signatures(MetalsSignatures.scala:17)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:375)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 1