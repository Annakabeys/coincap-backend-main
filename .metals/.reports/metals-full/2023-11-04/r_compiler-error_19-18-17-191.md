file://<WORKSPACE>/app/models/repo/PortfolioRepo.scala
### java.lang.IndexOutOfBoundsException: 0

occurred in the presentation compiler.

action parameters:
offset: 833
uri: file://<WORKSPACE>/app/models/repo/PortfolioRepo.scala
text:
```scala
package models.repo

import javax.inject._
import scala.concurrent.ExecutionContext
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
        def holdings = column[List[String]]("HOLDINGS")
        def quantity = column[Double]("QUANTITY")

        def * = (id, name, holdings, quantity).mapTo[@@]
    }
} 
```



#### Error stacktrace:

```
scala.collection.LinearSeqOps.apply(LinearSeq.scala:131)
	scala.collection.LinearSeqOps.apply$(LinearSeq.scala:128)
	scala.collection.immutable.List.apply(List.scala:79)
	dotty.tools.dotc.util.Signatures$.countParams(Signatures.scala:501)
	dotty.tools.dotc.util.Signatures$.applyCallInfo(Signatures.scala:186)
	dotty.tools.dotc.util.Signatures$.computeSignatureHelp(Signatures.scala:97)
	dotty.tools.dotc.util.Signatures$.signatureHelp(Signatures.scala:63)
	scala.meta.internal.pc.MetalsSignatures$.signatures(MetalsSignatures.scala:17)
	scala.meta.internal.pc.SignatureHelpProvider$.signatureHelp(SignatureHelpProvider.scala:51)
	scala.meta.internal.pc.ScalaPresentationCompiler.signatureHelp$$anonfun$1(ScalaPresentationCompiler.scala:375)
```
#### Short summary: 

java.lang.IndexOutOfBoundsException: 0