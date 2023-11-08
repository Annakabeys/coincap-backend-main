package models.repo

import javax.inject._
import scala.concurrent.{ExecutionContext, Future}
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import models.domain.Portfolio
import java.util.UUID

@Singleton
final class PortfolioRepo @Inject() (
    protected val dbConfigProvider: DatabaseConfigProvider,
    implicit val ec: ExecutionContext
) extends HasDatabaseConfigProvider[JdbcProfile] {

    import slick.jdbc.PostgresProfile.api._

    protected class PortfolioTable(tag: Tag) extends Table[Portfolio] (tag, "PORTFOLIOS") {
        def id = column[UUID]("ID", O.PrimaryKey)
        def name = column[String]("NAME")
        def holdings = column[String]("HOLDINGS")
        def quantity = column[BigDecimal]("QUANTITY")

        def * = (id, name, holdings, quantity).mapTo[Portfolio]
    }

    val portfolios = TableQuery[PortfolioTable]

    def createPortfolioTable: Future[Unit] = db.run(portfolios.schema.createIfNotExists)

    def getAllPortfolios = db.run(portfolios.result)

    def insert(portfolio: Portfolio) = db.run(portfolios += portfolio)

    def updatePortfolioName(id: UUID, newName: String): Future[Int] = db.run(portfolios.filter(_.id === id).map(p => p.name).update(newName))

    def deletePortfolio(id: UUID): Future[Int] = db.run(portfolios.filter(p => p.id === id).delete)
} 