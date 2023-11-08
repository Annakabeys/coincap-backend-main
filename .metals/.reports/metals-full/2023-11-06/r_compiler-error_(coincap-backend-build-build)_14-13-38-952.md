file://<HOME>/Downloads/New%20Folder%20With%20Items/coincap-backend/Main.scala
### java.lang.NullPointerException

occurred in the presentation compiler.

action parameters:
offset: 9
uri: file://<HOME>/Downloads/New%20Folder%20With%20Items/coincap-backend/Main.scala
text:
```scala
object Ma@@

```



#### Error stacktrace:

```
java.util.Arrays.sort(Arrays.java:1438)
	scala.tools.nsc.classpath.JFileDirectoryLookup.listChildren(DirectoryClassPath.scala:117)
	scala.tools.nsc.classpath.JFileDirectoryLookup.listChildren$(DirectoryClassPath.scala:101)
	scala.tools.nsc.classpath.DirectoryClassPath.listChildren(DirectoryClassPath.scala:292)
	scala.tools.nsc.classpath.DirectoryClassPath.listChildren(DirectoryClassPath.scala:292)
	scala.tools.nsc.classpath.DirectoryLookup.list(DirectoryClassPath.scala:82)
	scala.tools.nsc.classpath.DirectoryLookup.list$(DirectoryClassPath.scala:77)
	scala.tools.nsc.classpath.DirectoryClassPath.list(DirectoryClassPath.scala:292)
	scala.tools.nsc.classpath.AggregateClassPath.$anonfun$list$3(AggregateClassPath.scala:105)
	scala.collection.Iterator.foreach(Iterator.scala:943)
	scala.collection.Iterator.foreach$(Iterator.scala:943)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1431)
	scala.collection.IterableLike.foreach(IterableLike.scala:74)
	scala.collection.IterableLike.foreach$(IterableLike.scala:73)
	scala.collection.AbstractIterable.foreach(Iterable.scala:56)
	scala.tools.nsc.classpath.AggregateClassPath.list(AggregateClassPath.scala:101)
	scala.tools.nsc.util.ClassPath.list(ClassPath.scala:36)
	scala.tools.nsc.util.ClassPath.list$(ClassPath.scala:36)
	scala.tools.nsc.classpath.AggregateClassPath.list(AggregateClassPath.scala:30)
	scala.tools.nsc.symtab.SymbolLoaders$PackageLoader.doComplete(SymbolLoaders.scala:298)
	scala.tools.nsc.symtab.SymbolLoaders$SymbolLoader.complete(SymbolLoaders.scala:250)
	scala.reflect.internal.Symbols$Symbol.completeInfo(Symbols.scala:1542)
	scala.reflect.internal.Symbols$Symbol.info(Symbols.scala:1514)
	scala.reflect.internal.Types$TypeRef.decls(Types.scala:2283)
	scala.tools.nsc.typechecker.Namers$Namer.enterPackage(Namers.scala:766)
	scala.tools.nsc.typechecker.Namers$Namer.dispatch$1(Namers.scala:289)
	scala.tools.nsc.typechecker.Namers$Namer.standardEnterSym(Namers.scala:302)
	scala.tools.nsc.typechecker.AnalyzerPlugins.pluginsEnterSym(AnalyzerPlugins.scala:479)
	scala.tools.nsc.typechecker.AnalyzerPlugins.pluginsEnterSym$(AnalyzerPlugins.scala:478)
	scala.meta.internal.pc.MetalsGlobal$MetalsInteractiveAnalyzer.pluginsEnterSym(MetalsGlobal.scala:67)
	scala.tools.nsc.typechecker.Namers$Namer.enterSym(Namers.scala:280)
	scala.tools.nsc.typechecker.Analyzer$namerFactory$$anon$1.apply(Analyzer.scala:48)
	scala.tools.nsc.Global$GlobalPhase.applyPhase(Global.scala:454)
	scala.tools.nsc.Global$Run.$anonfun$compileLate$3(Global.scala:1656)
	scala.tools.nsc.Global$Run.$anonfun$compileLate$2(Global.scala:1656)
	scala.tools.nsc.Global$Run.$anonfun$compileLate$2$adapted(Global.scala:1655)
	scala.collection.Iterator.foreach(Iterator.scala:943)
	scala.collection.Iterator.foreach$(Iterator.scala:943)
	scala.collection.AbstractIterator.foreach(Iterator.scala:1431)
	scala.tools.nsc.Global$Run.compileLate(Global.scala:1655)
	scala.tools.nsc.interactive.Global.parseAndEnter(Global.scala:654)
	scala.tools.nsc.interactive.Global.typeCheck(Global.scala:664)
	scala.meta.internal.pc.HoverProvider.typedHoverTreeAt(HoverProvider.scala:298)
	scala.meta.internal.pc.HoverProvider.hoverOffset(HoverProvider.scala:43)
	scala.meta.internal.pc.HoverProvider.hover(HoverProvider.scala:22)
	scala.meta.internal.pc.ScalaPresentationCompiler.$anonfun$hover$1(ScalaPresentationCompiler.scala:313)
```
#### Short summary: 

java.lang.NullPointerException