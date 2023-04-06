import SwiftUI
import shared

struct NewsListView: View{
    @ObservedObject var state = NewsListState()
    
    var body: some View {
        NavigationView {
            List(state.items, id: \.self) { item in
                NavigationLink(destination: NewsItemView(item: item)) {
                    NewsItemRow(item: item)
                }
            }.onAppear{
                state.loadNews()
            }.navigationBarTitle("News", displayMode: .inline)
        }
    }
}
