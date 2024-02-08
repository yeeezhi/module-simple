package me.qingshou.common.util

import me.qingshou.common.util.StringUtil.isNotEmpty
import java.io.*
import java.net.HttpURLConnection
import java.net.URL
import java.net.URLEncoder
import java.security.KeyManagementException
import java.security.NoSuchAlgorithmException
import java.security.SecureRandom
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import javax.net.ssl.*

/**
 * http请求工具类
 *
 * @author handy
 */
object HttpUtil {
    const val REQUEST_TYPE_FORM = "application/x-www-form-urlencoded;charset=utf-8"
    private const val REQUEST_TYPE_JSON = "application/json; charset=utf-8"
    private const val REQUEST_TYPE_TEXT_HTML = "text/html; charset=utf-8";
    const val CHARSET = "utf-8"
    const val CONNECT_TIMEOUT = 5000
    const val READ_TIMEOUT = 5000
    const val HTTPS = "https"
    /**
     * POST 以application/json; charset=utf-8方式传输
     *
     * @param url         路径
     * @param jsonContent json参数
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    /**
     * POST 以application/json; charset=utf-8方式传输
     *
     * @param url         路径
     * @param jsonContent json参数
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    @JvmOverloads
    @Throws(NoSuchAlgorithmException::class, IOException::class, KeyManagementException::class)
    fun post(url: String, jsonContent: String, timeout: Int = CONNECT_TIMEOUT): String {
        return doRequest("POST", url, jsonContent, REQUEST_TYPE_TEXT_HTML, timeout)
    }
    /**
     * POST以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url     路径
     * @param timeout 超时时间
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    /**
     * POST以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url 路径
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    @JvmOverloads
    @Throws(NoSuchAlgorithmException::class, IOException::class, KeyManagementException::class)
    fun post(url: String, timeout: Int = CONNECT_TIMEOUT): String {
        return doRequest("POST", url, "", REQUEST_TYPE_FORM, timeout)
    }
    /**
     * POST 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url     路径
     * @param params  入参
     * @param timeout 超时时间
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    /**
     * POST 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url    路径
     * @param params 入参
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    @JvmOverloads
    @Throws(IOException::class, NoSuchAlgorithmException::class, KeyManagementException::class)
    fun post(url: String, params: Map<String, String>, timeout: Int = CONNECT_TIMEOUT): String {
        return doRequest("POST", url, buildQuery(params), REQUEST_TYPE_FORM, timeout)
    }
    /**
     * get 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url     路径
     * @param timeout 超时时间
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    /**
     * get 以application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url 路径
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    @JvmOverloads
    @Throws(NoSuchAlgorithmException::class, IOException::class, KeyManagementException::class)
    operator fun get(url: String, timeout: Int = CONNECT_TIMEOUT): String {
        return doRequest("GET", url, "", REQUEST_TYPE_FORM, timeout)
    }
    /**
     * get application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url     路径
     * @param params  参数
     * @param timeout 超时时间
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    /**
     * get application/x-www-form-urlencoded;charset=utf-8方式传输
     *
     * @param url    路径
     * @param params 参数
     * @return 响应
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     */
    @JvmOverloads
    @Throws(IOException::class, NoSuchAlgorithmException::class, KeyManagementException::class)
    operator fun get(url: String, params: Map<String, String>, timeout: Int = CONNECT_TIMEOUT): String {
        return doRequest("GET", url + buildQuery(params), "", REQUEST_TYPE_FORM, timeout)
    }

    /**
     * 请求
     *
     * @param method         方式
     * @param url            url
     * @param requestContent 请求内容
     * @param requestType    请求类型
     * @return 响应
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     */
    @Throws(IOException::class, KeyManagementException::class, NoSuchAlgorithmException::class)
    fun doRequest(
        method: String, url: String, requestContent: String, requestType: String, timeout: Int
    ): String {
        var conn: HttpURLConnection? = null
        var out: OutputStream? = null
        val rsp: String
        try {
            conn = getConnection(URL(url), method, requestType)
            conn.setConnectTimeout(timeout)
            conn.setReadTimeout(READ_TIMEOUT)
            if (isNotEmpty(requestContent)) {
                out = conn.outputStream
                out.write(requestContent.toByteArray(charset(CHARSET)))
            }
            rsp = getResponseAsString(conn)
        } finally {
            out?.close()
            conn?.disconnect()
        }
        return rsp
    }

    /**
     * 获取请求
     *
     * @param url         url
     * @param method      方法
     * @param requestType 请求类型
     * @return 响应
     * @throws IOException              IOException异常
     * @throws KeyManagementException   KeyManagementException异常
     * @throws NoSuchAlgorithmException NoSuchAlgorithmException异常
     */
    @Throws(NoSuchAlgorithmException::class, KeyManagementException::class, IOException::class)
    fun getConnection(url: URL, method: String, requestType: String): HttpURLConnection {
        val connection: HttpURLConnection
        if (HTTPS == url.protocol) {
            val ctx: SSLContext = SSLContext.getInstance("TLS")
            ctx.init(arrayOfNulls(0), arrayOf<TrustManager>(DefaultTrustManager()), SecureRandom())
            val connHttps = url.openConnection() as HttpsURLConnection
            connHttps.sslSocketFactory = ctx.socketFactory
            connHttps.hostnameVerifier = HostnameVerifier { _: String, _: SSLSession -> true }
            connection = connHttps
        } else {
            connection = url.openConnection() as HttpURLConnection
        }
        connection.setRequestMethod(method)
        connection.setDoInput(true)
        connection.setDoOutput(true)
        connection.setRequestProperty("Accept", "text/xml,text/javascript,text/html,application/json")
        connection.setRequestProperty("Content-Type", requestType)
        return connection
    }

    @Throws(IOException::class)
    fun getResponseAsString(conn: HttpURLConnection?): String {
        val es = conn!!.errorStream
        return if (es == null) {
            getStreamAsString(conn.inputStream)
        } else {
            getStreamAsString(es)
        }
    }

    @Throws(IOException::class)
    fun getStreamAsString(stream: InputStream): String {
        return try {
            val reader: Reader = InputStreamReader(stream, CHARSET)
            val response = StringBuilder()
            val buff = CharArray(1024)
            var read: Int
            while (reader.read(buff).also { read = it } > 0) {
                response.appendRange(buff, 0, read)
            }
            response.toString()
        } finally {
            stream.close()
        }
    }

    @Throws(UnsupportedEncodingException::class)
    fun buildQuery(params: Map<String, String>): String {
        if (params.isEmpty()) {
            return ""
        }
        val query = StringBuilder()
        query.append("?")
        val entries = params.entries
        var hasParam = false
        for ((name, value) in entries) {
            if (hasParam) {
                query.append("&")
            } else {
                hasParam = true
            }
            query.append(name).append("=").append(URLEncoder.encode(value, CHARSET))
        }
        return query.toString()
    }

    /**
     * 从网络URL中下载文件
     *
     * @param url   下载链接
     * @param saveDir  保存路径
     * @param fileName 文件名称
     * @throws IOException IOException异常
     */
    @Throws(IOException::class)
    fun downloadFile(url: URL, saveDir: File, fileName: String) {
        val conn = url.openConnection() as HttpURLConnection
        //设置超时间为3秒
        conn.setConnectTimeout(CONNECT_TIMEOUT)
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)")
        //得到输入流
        val inputStream = conn.inputStream
        //获取自己数组
        val getData = readInputStream(inputStream)
        //文件保存位置
        if (!saveDir.exists()) {
            saveDir.mkdir()
        }
        val file = File(saveDir.toString() + File.separator + fileName)
        val fos = FileOutputStream(file)
        fos.write(getData)
        fos.close()
        inputStream.close()
    }

    /**
     * 从网络URL中获取内容
     *
     * @param url   下载链接
     * @throws IOException IOException异常
     */
    @Throws(IOException::class)
    fun downloadContent(url: URL): String {
        val conn = url.openConnection() as HttpURLConnection
        //设置超时间为3秒
        conn.setConnectTimeout(CONNECT_TIMEOUT)
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)")
        //得到输入流
        val inputStream = conn.inputStream

        val content = String(conn.inputStream.readBytes(), charset("UTF-8"))
        inputStream.close()
        return content
    }

    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream 输入流
     * @return 响应
     * @throws IOException IOException异常
     */
    @Throws(IOException::class)
    fun readInputStream(inputStream: InputStream): ByteArray {
        var bos: ByteArrayOutputStream? = null
        return try {
            val buffer = ByteArray(1024)
            var len: Int
            bos = ByteArrayOutputStream()
            while (inputStream.read(buffer).also { len = it } != -1) {
                bos.write(buffer, 0, len)
            }
            bos.toByteArray()
        } finally {
            if (bos != null) {
                try {
                    bos.close()
                } catch (ioException: IOException) {
                    ioException.printStackTrace()
                }
            }
        }
    }

    class DefaultTrustManager : X509TrustManager {
        override fun getAcceptedIssuers(): Array<X509Certificate>? {
            return null
        }

        @Throws(CertificateException::class)
        override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String) {
        }

        @Throws(CertificateException::class)
        override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String) {
        }
    }
}