package com.github.furutuki.androidsvgtranscoder

import java.io.*
import java.net.URL

/**
 * Code template for generated android source
 *
 * @author furutuki
 * created on 2022/12/01
 */
class Template(url: URL) {

    init {
        load(url)
    }

    constructor(url: String) : this(Template::class.java.getResource(url))

    enum class Token {
        PACKAGE, CLASSNAME, PAINTING_CODE, X, Y, WIDTH, HEIGHT
    }

    private var url: URL? = null
    private var template: String? = null

    @Throws(IOException::class)
    private fun load(url: URL) {
        var inputStream: InputStream = url.openStream()
        this.url = url
        try {
            inputStream = url.openStream()
            val buffer = StringBuilder()
            val reader = BufferedReader(InputStreamReader(inputStream))
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                buffer.append(line).append("\n")
            }
            template = buffer.toString()
        } finally {
            inputStream.close()
        }
    }

    fun apply(out: PrintWriter?, params: MutableMap<Token, Any?>) {
        template?.run {
            var template = this
            for (token in params.keys) {
                template = template.replace(("\\$\\{" + token.name + "\\}").toRegex(), params[token].toString())
            }
            out?.run {
                println(template)
                close()
            }
        }
    }

    fun getURL(): URL? {
        return url
    }

    companion object {
        @JvmStatic
        fun getDefault(): Template {
            return try {
                Template("plain.template")
            } catch (e: IOException) {
                throw RuntimeException("Could not create default template", e)
            }
        }
    }
}