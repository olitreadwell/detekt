package dev.detekt.tooling.dsl

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class ReportsSpecSpec {

    private val reports = ReportsSpecBuilder().apply {
        report { "checkstyle" to Path("/tmp/path1") }
        report { "yml" to Path("/tmp/path3") }
        report { "html" to Path("""D:_Gradle\xxx\xxx\build\reports\detekt\detekt.html""") }
        report { "markdown" to Path("/tmp/path4") }
    }.build().reports.toList()

    @Test
    fun `should parse multiple report entries`() {
        assertThat(reports).hasSize(4)
    }

    @Test
    fun `it should properly parse Checkstyle report entry`() {
        val checkstyleReport = reports[0]
        assertThat(checkstyleReport.type).isEqualTo("checkstyle")
        assertThat(checkstyleReport.path).isEqualTo(Path("/tmp/path1"))
    }

    @Test
    fun `it should properly parse custom report entry`() {
        val customReport = reports[1]
        assertThat(customReport.type).isEqualTo("yml")
        assertThat(customReport.path).isEqualTo(Path("/tmp/path3"))
    }

    @Test
    fun `it should properly parse HTML report entry`() {
        val htmlReport = reports[2]
        assertThat(htmlReport.type).isEqualTo("html")
        assertThat(htmlReport.path).isEqualTo(
            Path("""D:_Gradle\xxx\xxx\build\reports\detekt\detekt.html""")
        )
    }

    @Test
    fun `it should properly parse Markdown report entry`() {
        val markdownReport = reports[3]
        assertThat(markdownReport.type).isEqualTo("markdown")
        assertThat(markdownReport.path).isEqualTo(Path("/tmp/path4"))
    }
}
