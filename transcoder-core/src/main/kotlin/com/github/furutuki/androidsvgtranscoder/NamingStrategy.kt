package com.github.furutuki.androidsvgtranscoder

import java.io.File

/**
 *
 * @author furutuki
 * created on 2022/12/01
 */
interface NamingStrategy {

    /**
     * Returns the name of the Icon class generated from the specified image file.
     *
     * @param file the image
     */
    fun getClassName(file: File): String
}