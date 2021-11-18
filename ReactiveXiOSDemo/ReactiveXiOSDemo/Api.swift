//
//  Api.swift
//  ReactiveXiOSDemo
//
//  Created by Hank on 2021/11/18.
//

import UIKit
import RxSwift

class Api: NSObject {

    func call(username: String, password: String) -> Observable<String> {
        return Observable.create { observable in
            
            if (username == "abc" && password == "0000") {
                observable.onNext("OK")
                observable.onCompleted()
            } else {
                observable.onError(NSError())
            }
            
            return Disposables.create {
                print("disposed")
            }
        }
    }
}
