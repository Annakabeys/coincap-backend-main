file://<WORKSPACE>/app/models/domain/Portfolio.scala
### java.lang.IllegalArgumentException: Comparison method violates its general contract!

occurred in the presentation compiler.

action parameters:
offset: 376
uri: file://<WORKSPACE>/app/models/domain/Portfolio.scala
text:
```scala
package models.domain

import java.util.UUID

case class Portfolio (
    id: UUID,
    name: String,
    holdings: List[String],
    quantity: Double
)

object Portfolio {
    val tupled = (apply: (UUID, String, List[String], Double) => Portfolio).tupled
    def apply (id: UUID, name: String, holdings: List[String], quantity: Doublt): Portfolio = apply(id, name, holdings, q@@)
}
```



#### Error stacktrace:

```
java.util.TimSort.mergeLo(TimSort.java:777)
	java.util.TimSort.mergeAt(TimSort.java:514)
	java.util.TimSort.mergeForceCollapse(TimSort.java:457)
	java.util.TimSort.sort(TimSort.java:254)
	java.util.Arrays.sort(Arrays.java:1438)
	scala.collection.SeqOps.sorted(Seq.scala:727)
	scala.collection.SeqOps.sorted$(Seq.scala:719)
	scala.collection.immutable.List.scala$collection$immutable$StrictOptimizedSeqOps$$super$sorted(List.scala:79)
	scala.collection.immutable.StrictOptimizedSeqOps.sorted(StrictOptimizedSeqOps.scala:78)
	scala.collection.immutable.StrictOptimizedSeqOps.sorted$(StrictOptimizedSeqOps.scala:78)
	scala.collection.immutable.List.sorted(List.scala:79)
	scala.meta.internal.pc.completions.Completions.completions(Completions.scala:210)
	scala.meta.internal.pc.completions.CompletionProvider.completions(CompletionProvider.scala:86)
	scala.meta.internal.pc.ScalaPresentationCompiler.complete$$anonfun$1(ScalaPresentationCompiler.scala:123)
```
#### Short summary: 

java.lang.IllegalArgumentException: Comparison method violates its general contract!