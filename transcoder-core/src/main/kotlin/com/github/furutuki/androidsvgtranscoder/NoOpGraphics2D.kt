package com.github.furutuki.androidsvgtranscoder

import java.awt.*
import java.awt.font.FontRenderContext
import java.awt.font.GlyphVector
import java.awt.geom.AffineTransform
import java.awt.image.BufferedImage
import java.awt.image.BufferedImageOp
import java.awt.image.ImageObserver
import java.awt.image.RenderedImage
import java.awt.image.renderable.RenderableImage
import java.text.AttributedCharacterIterator


/**
 *
 * @author furutuki
 * created on 2022/12/01
 */
open class NoOpGraphics2D: Graphics2D() {

    override fun draw(shape: Shape) {
        throw UnsupportedOperationException()
    }

    override fun drawImage(img: Image, xform: AffineTransform, obs: ImageObserver): Boolean {
        throw UnsupportedOperationException()
    }

    override fun drawImage(img: BufferedImage, op: BufferedImageOp, x: Int, y: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawRenderedImage(img: RenderedImage, xform: AffineTransform) {
        throw UnsupportedOperationException()
    }

    override fun drawRenderableImage(img: RenderableImage, xform: AffineTransform) {
        throw UnsupportedOperationException()
    }

    override fun drawString(str: String, x: Int, y: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawString(str: String, x: Float, y: Float) {
        throw UnsupportedOperationException()
    }

    override fun drawString(iterator: AttributedCharacterIterator, x: Int, y: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawString(iterator: AttributedCharacterIterator, x: Float, y: Float) {
        throw UnsupportedOperationException()
    }

    override fun drawGlyphVector(g: GlyphVector, x: Float, y: Float) {
        throw UnsupportedOperationException()
    }

    override fun fill(shape: Shape) {
        throw UnsupportedOperationException()
    }

    override fun hit(rect: Rectangle, s: Shape, onStroke: Boolean): Boolean {
        throw UnsupportedOperationException()
    }

    override fun getDeviceConfiguration(): GraphicsConfiguration {
        throw UnsupportedOperationException()
    }

    override fun setComposite(comp: Composite) {
        throw UnsupportedOperationException()
    }

    override fun setPaint(paint: Paint) {
        throw UnsupportedOperationException()
    }

    override fun setStroke(s: Stroke) {
        throw UnsupportedOperationException()
    }

    override fun setRenderingHint(hintKey: RenderingHints.Key, hintValue: Any) {
        throw UnsupportedOperationException()
    }

    override fun getRenderingHint(hintKey: RenderingHints.Key): Any {
        throw UnsupportedOperationException()
    }

    override fun setRenderingHints(hints: Map<*, *>) {
        throw UnsupportedOperationException()
    }

    override fun addRenderingHints(hints: Map<*, *>) {
        throw UnsupportedOperationException()
    }

    override fun getRenderingHints(): RenderingHints {
        throw UnsupportedOperationException()
    }

    override fun translate(x: Int, y: Int) {
        throw UnsupportedOperationException()
    }

    override fun translate(tx: Double, ty: Double) {
        throw UnsupportedOperationException()
    }

    override fun rotate(theta: Double) {
        throw UnsupportedOperationException()
    }

    override fun rotate(theta: Double, x: Double, y: Double) {
        throw UnsupportedOperationException()
    }

    override fun scale(sx: Double, sy: Double) {
        throw UnsupportedOperationException()
    }

    override fun shear(shx: Double, shy: Double) {
        throw UnsupportedOperationException()
    }

    override fun transform(Tx: AffineTransform) {
        throw UnsupportedOperationException()
    }

    override fun setTransform(Tx: AffineTransform) {
        throw UnsupportedOperationException()
    }

    override fun getTransform(): AffineTransform {
        throw UnsupportedOperationException()
    }

    override fun getPaint(): Paint {
        throw UnsupportedOperationException()
    }

    override fun getComposite(): Composite {
        throw UnsupportedOperationException()
    }

    override fun setBackground(color: Color) {
        throw UnsupportedOperationException()
    }

    override fun getBackground(): Color {
        throw UnsupportedOperationException()
    }

    override fun getStroke(): Stroke {
        throw UnsupportedOperationException()
    }

    override fun clip(s: Shape) {
        throw UnsupportedOperationException()
    }

    override fun getFontRenderContext(): FontRenderContext {
        throw UnsupportedOperationException()
    }

    override fun create(): Graphics {
        throw UnsupportedOperationException()
    }

    override fun getColor(): Color {
        throw UnsupportedOperationException()
    }

    override fun setColor(c: Color) {
        throw UnsupportedOperationException()
    }

    override fun setPaintMode() {
        throw UnsupportedOperationException()
    }

    override fun setXORMode(c1: Color) {
        throw UnsupportedOperationException()
    }

    override fun getFont(): Font {
        throw UnsupportedOperationException()
    }

    override fun setFont(font: Font) {
        throw UnsupportedOperationException()
    }

    override fun getFontMetrics(f: Font): FontMetrics {
        throw UnsupportedOperationException()
    }

    override fun getClipBounds(): Rectangle {
        throw UnsupportedOperationException()
    }

    override fun clipRect(x: Int, y: Int, width: Int, height: Int) {
        throw UnsupportedOperationException()
    }

    override fun setClip(x: Int, y: Int, width: Int, height: Int) {
        throw UnsupportedOperationException()
    }

    override fun getClip(): Shape {
        throw UnsupportedOperationException()
    }

    override fun setClip(clip: Shape) {
        throw UnsupportedOperationException()
    }

    override fun copyArea(x: Int, y: Int, width: Int, height: Int, dx: Int, dy: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawLine(x1: Int, y1: Int, x2: Int, y2: Int) {
        throw UnsupportedOperationException()
    }

    override fun fillRect(x: Int, y: Int, width: Int, height: Int) {
        throw UnsupportedOperationException()
    }

    override fun clearRect(x: Int, y: Int, width: Int, height: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawRoundRect(
        x: Int,
        y: Int,
        width: Int,
        height: Int,
        arcWidth: Int,
        arcHeight: Int
    ) {
        throw UnsupportedOperationException()
    }

    override fun fillRoundRect(
        x: Int,
        y: Int,
        width: Int,
        height: Int,
        arcWidth: Int,
        arcHeight: Int
    ) {
        throw UnsupportedOperationException()
    }

    override fun drawOval(x: Int, y: Int, width: Int, height: Int) {
        throw UnsupportedOperationException()
    }

    override fun fillOval(x: Int, y: Int, width: Int, height: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawArc(x: Int, y: Int, width: Int, height: Int, startAngle: Int, arcAngle: Int) {
        throw UnsupportedOperationException()
    }

    override fun fillArc(x: Int, y: Int, width: Int, height: Int, startAngle: Int, arcAngle: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawPolyline(xPoints: IntArray, yPoints: IntArray, nPoints: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawPolygon(xPoints: IntArray, yPoints: IntArray, nPoints: Int) {
        throw UnsupportedOperationException()
    }

    override fun fillPolygon(xPoints: IntArray, yPoints: IntArray, nPoints: Int) {
        throw UnsupportedOperationException()
    }

    override fun drawImage(img: Image, x: Int, y: Int, observer: ImageObserver): Boolean {
        throw UnsupportedOperationException()
    }

    override fun drawImage(
        img: Image,
        x: Int,
        y: Int,
        width: Int,
        height: Int,
        observer: ImageObserver
    ): Boolean {
        throw UnsupportedOperationException()
    }

    override fun drawImage(
        img: Image,
        x: Int,
        y: Int,
        bgcolor: Color,
        observer: ImageObserver
    ): Boolean {
        throw UnsupportedOperationException()
    }

    override fun drawImage(
        img: Image,
        x: Int,
        y: Int,
        width: Int,
        height: Int,
        bgcolor: Color,
        observer: ImageObserver
    ): Boolean {
        throw UnsupportedOperationException()
    }

    override fun drawImage(
        img: Image,
        dx1: Int,
        dy1: Int,
        dx2: Int,
        dy2: Int,
        sx1: Int,
        sy1: Int,
        sx2: Int,
        sy2: Int,
        observer: ImageObserver
    ): Boolean {
        throw UnsupportedOperationException()
    }

    override fun drawImage(
        img: Image,
        dx1: Int,
        dy1: Int,
        dx2: Int,
        dy2: Int,
        sx1: Int,
        sy1: Int,
        sx2: Int,
        sy2: Int,
        bgcolor: Color,
        observer: ImageObserver
    ): Boolean {
        throw UnsupportedOperationException()
    }

    override fun dispose() {
        throw UnsupportedOperationException()
    }
}