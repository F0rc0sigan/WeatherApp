# Keep `Companion` object fields of serializable classes.
# This avoids serializer lookup through `getDeclaredClasses` as done for named companion objects.
-if @kotlinx.serialization.Serializable class **
-keepclassmembers class <1> {
    static <1>$Companion Companion;
}

# Keep `serializer()` on companion objects (both default and named) of serializable classes.
-if @kotlinx.serialization.Serializable class ** {
    static **$* *;
}
-keepclassmembers class <2>$<3> {
    kotlinx.serialization.KSerializer serializer(...);
}

# Keep `INSTANCE.serializer()` of serializable objects.
-if @kotlinx.serialization.Serializable class ** {
    public static ** INSTANCE;
}
-keepclassmembers class <1> {
    public static <1> INSTANCE;
    kotlinx.serialization.KSerializer serializer(...);
}

# @Serializable and @Polymorphic are used at runtime for polymorphic serialization.
-keepattributes RuntimeVisibleAnnotations,AnnotationDefault

# Serializer for classes with named companion objects are retrieved using `getDeclaredClasses`.
# If you have any, uncomment and replace classes with those containing named companion objects.
#-keepattributes InnerClasses # Needed for `getDeclaredClasses`.
#-if @kotlinx.serialization.Serializable class
#com.example.myapplication.HasNamedCompanion, # <-- List serializable classes with named companions.
#com.example.myapplication.HasNamedCompanion2
#{
#    static **$* *;
#}
#-keepnames class <1>$$serializer { # -keepnames suffices; class is kept when serializer() is kept.
#    static <1>$$serializer INSTANCE;
#}

-dontwarn org.slf4j.impl.StaticLoggerBinder
-dontwarn android.support.annotation.NonNull
-dontwarn android.support.annotation.Nullable
-dontwarn android.support.annotation.RequiresApi
-dontwarn android.support.annotation.VisibleForTesting
-dontwarn androidx.asynclayoutinflater.view.AsyncLayoutInflater$OnInflateFinishedListener
-dontwarn androidx.asynclayoutinflater.view.AsyncLayoutInflater
-dontwarn org.jetbrains.kotlin.compiler.plugin.CliOption
-dontwarn org.jetbrains.kotlin.compiler.plugin.CommandLineProcessor
-dontwarn org.jetbrains.kotlin.compiler.plugin.ComponentRegistrar
-dontwarn org.jetbrains.kotlin.diagnostics.DiagnosticFactory0
-dontwarn org.jetbrains.kotlin.diagnostics.DiagnosticFactory1
-dontwarn org.jetbrains.kotlin.diagnostics.DiagnosticFactory2
-dontwarn org.jetbrains.kotlin.diagnostics.DiagnosticFactory3
-dontwarn org.jetbrains.kotlin.diagnostics.Errors$Initializer
-dontwarn org.jetbrains.kotlin.diagnostics.PositioningStrategies
-dontwarn org.jetbrains.kotlin.diagnostics.PositioningStrategy
-dontwarn org.jetbrains.kotlin.diagnostics.Severity
-dontwarn org.jetbrains.kotlin.diagnostics.rendering.CommonRenderers
-dontwarn org.jetbrains.kotlin.diagnostics.rendering.ContextIndependentParameterRenderer
-dontwarn org.jetbrains.kotlin.diagnostics.rendering.DefaultErrorMessages$Extension
-dontwarn org.jetbrains.kotlin.diagnostics.rendering.DiagnosticFactoryToRendererMap
-dontwarn org.jetbrains.kotlin.diagnostics.rendering.DiagnosticParameterRenderer
-dontwarn org.jetbrains.kotlin.diagnostics.rendering.Renderers
-dontwarn org.jetbrains.kotlin.diagnostics.rendering.SmartDescriptorRenderer
-dontwarn org.jetbrains.kotlin.diagnostics.rendering.SmartTypeRenderer

-dontwarn com.google.auto.service.AutoService
-dontwarn javax.lang.model.SourceVersion
-dontwarn javax.lang.model.element.AnnotationMirror
-dontwarn javax.lang.model.element.AnnotationValue
-dontwarn javax.lang.model.element.Element
-dontwarn javax.lang.model.element.ElementKind
-dontwarn javax.lang.model.element.ElementVisitor
-dontwarn javax.lang.model.element.ExecutableElement
-dontwarn javax.lang.model.element.Name
-dontwarn javax.lang.model.element.PackageElement
-dontwarn javax.lang.model.element.TypeElement
-dontwarn javax.lang.model.element.TypeParameterElement
-dontwarn javax.lang.model.element.VariableElement
-dontwarn javax.lang.model.type.ArrayType
-dontwarn javax.lang.model.type.DeclaredType
-dontwarn javax.lang.model.type.ExecutableType
-dontwarn javax.lang.model.type.TypeKind
-dontwarn javax.lang.model.type.TypeMirror
-dontwarn javax.lang.model.type.TypeVariable
-dontwarn javax.lang.model.type.TypeVisitor
-dontwarn javax.lang.model.util.AbstractAnnotationValueVisitor8
-dontwarn javax.lang.model.util.AbstractTypeVisitor8
-dontwarn javax.lang.model.util.ElementFilter
-dontwarn javax.lang.model.util.Elements
-dontwarn javax.lang.model.util.SimpleElementVisitor8
-dontwarn javax.lang.model.util.SimpleTypeVisitor7
-dontwarn javax.lang.model.util.SimpleTypeVisitor8
-dontwarn javax.lang.model.util.Types
-dontwarn javax.tools.Diagnostic$Kind