import SwiftUI
import SharedLogic

enum ContentViewState {
    case loading
    case loaded([RadioStation])
    case failed(String)
}

struct ContentView: View {
    @State private var state: ContentViewState = .loading
    
    var body: some View {
        Group {
            switch state {
            case .loading:
                ProgressView("Loading stations…")
                    .frame(maxWidth: .infinity, maxHeight: .infinity)
                
            case .loaded(let stations):
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
                
            case .failed(let message):
                ContentUnavailableView(
                    "Couldn't load stations",
                    systemImage: "wifi.exclamationmark",
                    description: Text(message)
                )
            }
        }
        
        .task {
            do {
                let stations = try await KoinIosKt.radioRepository().getRadioStations()
                state = .loaded(stations)
            } catch {
                state = .failed(error.localizedDescription)
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
