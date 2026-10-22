package dev.detekt.core.reporting

import dev.detekt.api.Detektion
import dev.detekt.api.OutputReport
import dev.detekt.core.createNullLoggingSpec
import dev.detekt.core.createProcessingSettings
import dev.detekt.core.extensions.loadExtensions
import dev.detekt.core.tooling.withSettings
import dev.detekt.test.utils.resourceAsPath
import dev.detekt.tooling.dsl.ReportsSpecBuilder
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Condition
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.io.path.Path

class OutputReportLoadingSpec {

    @Nested
    inner class `default report ids` {

        private val reports = ReportsSpecBuilder().apply {
            report { "checkstyle" to Path("/tmp/path1") }
            report { "yml" to Path("/tmp/path3") }
            report { "html" to Path("""D:_Gradle\xxx\xxx\build\reports\detekt\detekt.html""") }
            report { "markdown" to Path("/tmp/path4") }
        }.build().reports.toList()

        private val extensions = createProcessingSettings().use { loadExtensions<OutputReport>(it) }
        private val extensionsIds = extensions.mapTo(HashSet()) { it.id }

        @Test
        fun `should be able to convert to output reports`() {
            assertThat(reports).allMatch { it.type in extensionsIds }
        }

        @Test
        fun `should recognize custom output format`() {
            assertThat(reports).haveExactly(
                1,
                Condition({ it.type == "yml" }, "Corresponds exactly to the test output report.")
            )
        }
    }

    @Nested
    inner class `empty reports` {

        @Test
        fun `yields empty extension list`() {
            val spec = createNullLoggingSpec {
                config {
                    configPaths = listOf(resourceAsPath("/reporting/disabled-reports.yml"))
                }
            }

            val extensions = spec.withSettings { loadConsoleReport(this) }

            assertThat(extensions).isEmpty()
        }
    }
}

class TestOutputReport : OutputReport {
    override val id: String = "yml"

    override fun render(detektion: Detektion) = throw UnsupportedOperationException("not implemented")
}
