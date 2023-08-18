package taboolib.module.simple.util

import taboolib.common.platform.function.warning
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

object NativeLoader {
    private val NATIVE_LOADER_LOCK = Any()
    private var NATIVES_LOADED = false

    /**
     * Handles native-loading for the finished jars
     */
    fun loadNatives() {
        synchronized(NATIVE_LOADER_LOCK) {
            if (NATIVES_LOADED) return
            val isX64 = System.getProperty("os.arch").contains("64")
            val lowerCase = System.getProperty("os.name").lowercase(Locale.getDefault())
            var name: String? = null
            if (isX64) {
                if (lowerCase.contains("win")) {
                    name = "mlv-win64.dll"
                }
                if (lowerCase.contains("linux")) {
                    name = "mlv-linux64.so"
                }
                if (lowerCase.contains("mac")) {
                    name = "mlv-macos.dylib"
                }
            }
            if (name == null) {
                throw Error("No natives found for " + lowerCase + if (isX64) " x86-64" else "x86")
            }
            val tmpFile = File.createTempFile("mlv_", ".tmp")
            try {
                NativeLoader::class.java.getResourceAsStream("/META-INF/natives/$name").use { inputStream ->
                    if (inputStream == null) {
                        warning("动态链路库 $name 不存在")
                        return
                    }
                    FileOutputStream(tmpFile).use { fos ->
                        val buf = ByteArray(1024)
                        var read: Int
                        while (inputStream.read(buf).also { read = it } != -1) {
                            fos.write(buf, 0, read)
                        }
                    }
                }
            } catch (e: IOException) {
                throw Error("Failed to load natives", e)
            }
            System.load(tmpFile.absolutePath)
            NATIVES_LOADED = true
        }
    }
}