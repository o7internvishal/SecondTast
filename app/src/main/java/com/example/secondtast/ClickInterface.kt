package com.example.secondtast

import com.example.secondtast.model.UserData


interface ClickInterface {
    fun editClicked(userData: UserData)
    fun deleteClicked(userData: UserData)
}