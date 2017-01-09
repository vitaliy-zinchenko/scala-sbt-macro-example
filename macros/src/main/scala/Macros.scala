import scala.reflect.macros.blackbox.Context
import scala.language.experimental.macros
import scala.annotation.StaticAnnotation

object getParamNamesMacro {
  def impl(c: Context)(annottees: c.Expr[Any]*): c.Expr[Any] = {
    import c.universe._
    val result = {
      annottees.map(_.tree).toList match {
        case q"$mods def $methodName[..$tpes](...$args): $returnType = { ..$body }" :: Nil =>
          val params: List[ValDef] = args.head.asInstanceOf[List[ValDef]] //assume only one argument group exists
          val names = params.map { valDef =>
            valDef.name.toString
          }

          val paramsName = TermName(methodName + "Params")

          q"""
            $mods def $methodName[..$tpes](...$args): $returnType =  { ..$body }

            val ${paramsName}: List[String] = ${names}
          """
      }
    }
    c.Expr[Any](result)
  }
}

class getParamNames extends StaticAnnotation {
  def macroTransform(annottees: Any*) = macro getParamNamesMacro.impl
}
