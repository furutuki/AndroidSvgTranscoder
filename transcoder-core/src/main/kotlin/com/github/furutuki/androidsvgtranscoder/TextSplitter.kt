package com.github.furutuki.androidsvgtranscoder

import java.io.IOException
import java.io.LineNumberReader
import java.io.StringReader
import java.util.*

/**
 *
 * @author furutuki
 * created on 2022/12/01
 */
object TextSplitter {

    fun insert(content: String, separator: String, limit: Int): String {
        if (content.trim { it <= ' ' }.isEmpty()) {
            return content
        }
        val out = StringBuilder()
        val chunks = getChunks(content)
        var accumulatedLines = 0
        var separatorCount = 0
        for (i in chunks.indices) {
            val chunk = chunks[i]
            if (accumulatedLines > 0 && accumulatedLines + chunk.lines > limit) {
                out.append(separator.replace("\\$\\{count}".toRegex(), (++separatorCount).toString()))
                out.append('\n')
                accumulatedLines = 0
            } else if (i > 0) {
                out.append('\n')
            }
            accumulatedLines += chunk.lines
            out.append(chunk.content)
        }
        return out.toString()
    }

    private fun getChunks(content: String): List<Chunk> {
        val chunks: MutableList<Chunk> = LinkedList()
        var chunk = Chunk()
        chunks.add(chunk)
        try {
            val reader = LineNumberReader(StringReader(content))
            var line: String? = reader.readLine()
            while (line != null) {
                if (line.trim { it <= ' ' }.isEmpty()) {
                    chunk = Chunk()
                    chunks.add(chunk)
                } else {
                    chunk.content.append(line).append('\n')
                    chunk.lines++
                }
                line = reader.readLine()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return chunks
    }

    class Chunk {
        var content = StringBuilder()
        var lines = 0
    }
}