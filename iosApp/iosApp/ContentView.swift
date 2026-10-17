import SwiftUI
import SharedLogic

struct ContentView: View {
    @State private var stations: [RadioStation] = []
    
    var body: some View {
        ScrollView {
            LazyVGrid(
                columns: [GridItem(.adaptive(minimum: 100), spacing: 12)],
                spacing: 12
            ) {
                ForEach(stations, id: \.id) { station in
                    StationCard(station: station)
                }
            }
            .padding(16)
        }
        .task {
            do {
                stations = try await KoinIosKt.radioRepository().getRadioStations()
            } catch {
                
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
