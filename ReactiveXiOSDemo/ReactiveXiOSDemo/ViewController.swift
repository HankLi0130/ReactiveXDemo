//
//  ViewController.swift
//  ReactiveXiOSDemo
//
//  Created by Hank on 2021/11/18.
//

import UIKit
import RxSwift

class ViewController: UIViewController {

    @IBOutlet weak var inputUsername: UITextField!
    @IBOutlet weak var inputPassword: UITextField!
    @IBOutlet weak var labelResult: UILabel!
    
    private let viewModel = ViewModel()
    private var disposable: Disposable? = nil

    override func viewDidLoad() {
        super.viewDidLoad()
    }
    
    
    override func viewDidDisappear(_ animated: Bool) {
        super.viewDidDisappear(animated)
        disposable?.dispose()
    }

    @IBAction func submit(_ sender: UIButton) {
        labelResult.text = "result"
        
        let username = inputUsername.text ?? ""
        let password = inputPassword.text ?? ""

        self.disposable = viewModel.login(username: username, password: password)
            .subscribe { result in
                print("onNext")
                self.labelResult.text = result
            } onError: { err in
                print("onError")
                self.labelResult.text = "Wrong username or password"
            } onCompleted: {
                print("onCompleted")
            } onDisposed: {
                print("onDisposed")
            }
        
    }

}

