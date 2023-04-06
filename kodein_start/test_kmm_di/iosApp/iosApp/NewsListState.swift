//
//  NewsListModel.swift
//  iosApp
//
//  Created by Anna Zharkova on 03.10.2021.
//  Copyright © 2021 orgName. All rights reserved.
//


import Foundation
import SwiftUI
import shared

class NewsListState : ObservableObject, NewsView {
    func showError(text: String) {
        
    }
    
    func showInfo(text: String) {
        
    }
    
    func startLoading() {
        
    }
    
    func stopLoading() {
        
    }
    
    
    private var vm: NewsViewModel? = null
    
    lazy var itemsCollector: Observer = {
        let collector = Observer { [weak self] value in
            guard let self = self else {return}
            if let value = value as? NewsList {
                self.items = value.articles ?? [NewsItem]()
            }
        }
        return collector
    }()
    
    @Published var items: [NewsItem] = [NewsItem]()
    
    func loadNews() {
       vm?.loadNews()
    }
}

