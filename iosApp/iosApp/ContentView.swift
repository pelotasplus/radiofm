import SwiftUI
import SharedLogic

struct ContentView: View {
    @State private var showContent = false
    @State private var stations: [RadioStation] = []
    
    var body: some View {
        ScrollView {
            VStack {
                Button("Click me!") {
                    withAnimation {
                        showContent = !showContent
                    }
                }
                
                if showContent {
                    VStack(spacing: 16) {
                        Image(systemName: "swift")
                            .font(.system(size: 200))
                            .foregroundColor(.accentColor)
                        Text("SwiftUI: \(Greeting().greet())")
                        ForEach(stations, id: \.name) { station in
                            Text(station.name)
                        }
                    }
                    .transition(.move(edge: .top).combined(with: .opacity))
                }
            }
            .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: .top)
            .padding()
            .task {
                do {
                    stations = try await KoinIosKt.radioRepository().getStations()
                } catch {
                    
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
