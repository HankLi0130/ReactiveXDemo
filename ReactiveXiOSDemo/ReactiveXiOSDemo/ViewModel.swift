//
//  ViewModel.swift
//  ReactiveXiOSDemo
//
//  Created by Hank on 2021/11/18.
//

import UIKit
import RxSwift

class ViewModel: NSObject {
    
    private let api = Api()

    func login(username: String, password: String) -> Observable<String> {
        return api.call(username: username, password: password)
            .subscribe(on: SerialDispatchQueueScheduler.init(qos: .background))
            .observe(on: MainScheduler.instance)
    }
}
