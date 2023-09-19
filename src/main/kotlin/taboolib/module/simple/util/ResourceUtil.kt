package taboolib.module.simple.util

import org.bukkit.plugin.Plugin
import java.io.File
import java.io.OutputStreamWriter
import java.io.Writer
import java.nio.file.Files

/**
 * 资源文件解压工具
 */
object ResourceUtil {
    /**
     * 解压资源文件
     *
     * @param folderName 目录名
     * @param fileNames  文件名
     */
    fun Plugin.saveResource(folderName: String, fileNames: Array<String>) {
        if (fileNames.isEmpty()) {
            return
        }
        val folder = File(this.dataFolder, folderName)
        var charset = "US-ASCII"
        var vTmp = this.server.bukkitVersion.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()[1]
        vTmp = if (vTmp.contains("-")) vTmp.split("\\-".toRegex()).dropLastWhile { it.isEmpty() }
            .toTypedArray()[0] else vTmp
        if (vTmp.toInt() > 8) {
            charset = "UTF-8"
        }
        if (folder.exists()) {
            return
        }
        folder.mkdirs()
        for (fileName in fileNames) {
            val path = "$folderName/$fileName"
            val saveFile = File(folder, fileName)
            if (!saveFile.exists()) {
                try {
                    saveFile.createNewFile()
                } catch (ignored: Exception) {
                }
            }
            val `in` = this.getResource(path)
            var out: Writer? = null
            if (`in` == null) {
                continue
            }
            try {
                out = OutputStreamWriter(Files.newOutputStream(saveFile.toPath()), charset)
                val data = ByteArray(1024)
                var len: Int
                while (`in`.read(data).also { len = it } > 0) {
                    out.write(String(data, 0, len, charset(charset)))
                }
            } catch (ignored: Exception) {
            } finally {
                try {
                    `in`.close()
                } catch (ignored: Exception) {
                }
                if (out != null) {
                    try {
                        out.close()
                    } catch (ignored: Exception) {
                    }
                }
            }
        }
    }
}
