import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.example.common.App
import com.example.common.di.AppModule


fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "Todo App") {
        App(
            appModule = AppModule()
        )
    }
}
