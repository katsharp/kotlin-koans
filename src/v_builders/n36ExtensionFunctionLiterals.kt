package v_builders

import util.TODO
import util.doc36

fun todoTask36(): Nothing = TODO(
    """
        Task 36.
        Read about extension function literals.
        You can declare `isEven` and `isOdd` as values, that can be called as extension functions.
        Complete the declarations below.
    """,
    documentation = doc36()
)

fun task36(): List<Boolean> {
    val isEven: Int.() -> Boolean = { this % 2 == 0 }
    val isOdd: Int.() -> Boolean = {!this.isEven() }

    return listOf(42.isOdd(), 239.isOdd(), 294823098.isEven())
}



class Config(var buildType: String, var version: String)

val map = hashMapOf<String, Config>()

fun configurationFor(id: String) = map[id]?.let { config ->
    config.apply {
        buildType = "DEBUG"
        version = "1.2"
    }
}

fun configurationFor2(id: String) = map[id]?.apply {
    buildType = "DEBUG"
    version = "1.2"
}