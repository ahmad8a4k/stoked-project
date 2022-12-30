package com.example.domin.endPoints

sealed class AuthenticationEndPoint(val path:String){
    object Root: AuthenticationEndPoint(path = "/")
    object SignUp: AuthenticationEndPoint(path = "user/add_user")
    object SignIn: AuthenticationEndPoint(path = "user/sign_in")
    object Authenticate: AuthenticationEndPoint(path = "user/authenticate")
    object Secret: AuthenticationEndPoint(path = "user/secret")
    object UpdatePassword: AuthenticationEndPoint(path = "user/update_password")
    object DeleteUserByUsernameAndPassword: AuthenticationEndPoint(path = "user/delete_user")
    object ListOfRoles: AuthenticationEndPoint("user/roles")
}