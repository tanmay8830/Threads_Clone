package com.example.threads_clone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.threads_clone.model.ThreadModel
import com.example.threads_clone.model.UserModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class SearchViewModel:ViewModel() {


    private val db: FirebaseDatabase = FirebaseDatabase.getInstance()
    val users: DatabaseReference = db.getReference("users")





    private var _users = MutableLiveData<List<UserModel>>()
    val userList: LiveData<List<UserModel>> = _users



    init {
        fetchuser {
            _users .value= it
        }
    }





    private fun fetchuser(onResult: (List<UserModel>)->Unit){
        users.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot){


                val result = mutableListOf<UserModel>()
                for (threadSnapshot in snapshot.children){
                    val thread = threadSnapshot.getValue(UserModel::class.java)
                    result.add(thread!!)


                        }
                        onResult(result)
                    }

            override fun onCancelled(error: DatabaseError) {

            }


        })
    }




}


