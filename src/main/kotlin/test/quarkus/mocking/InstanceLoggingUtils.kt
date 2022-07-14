package test.quarkus.mocking

fun logClassAndHash(label: String, obj: Any) {
    println("___________________________________")
    println("label: $label")
    println(obj.javaClass)
    println(obj.hashCode())
    println("___________________________________")
}