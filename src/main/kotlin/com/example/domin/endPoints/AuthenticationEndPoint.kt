package com.example.domin.endPoints

sealed class AuthenticationEndPoint(val path:String){
    object Root: AuthenticationEndPoint(path = "/")
    object SignUp: AuthenticationEndPoint(path = "addUser")
    object SignIn: AuthenticationEndPoint(path = "signIn")
    object Authenticate: AuthenticationEndPoint(path = "authenticate")
    object Secret: AuthenticationEndPoint(path = "secret")
    object UpdatePassword: AuthenticationEndPoint(path = "updatePassword")
    object DeleteUserByUsernameAndPassword: AuthenticationEndPoint(path = "deleteUser")
    object ListOfRoles: AuthenticationEndPoint("listOfRoles")
}