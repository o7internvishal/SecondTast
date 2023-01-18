package com.example.secondtast
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondtast.model.UserData
import com.example.secondtast.view.UserAdapter
import java.text.FieldPosition

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddFragment : Fragment(), ClickInterface {

    lateinit var recyclerView: RecyclerView
    var userList = ArrayList<UserData>()

    lateinit var userAdapter: UserAdapter

    lateinit var etItem: EditText
    lateinit var etDescription: EditText


    lateinit var addButton: Button

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var mainActivity: MainActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        val button = view.findViewById<Button>(R.id.btAdd)
        userAdapter = UserAdapter(userList, this)

        recyclerView.layoutManager = LinearLayoutManager(mainActivity)
        recyclerView.adapter = userAdapter


        button.setOnClickListener {
            val inflater = LayoutInflater.from(mainActivity)
            val v = inflater.inflate(R.layout.custom_dialogbox, null)
            val addDialog = AlertDialog.Builder(mainActivity)
            addDialog.create()
            addDialog.setView(v)
            etItem = v.findViewById(R.id.etMenu)
            etDescription = v.findViewById(R.id.etDescription)
            addDialog.setPositiveButton("Add") { dialog, _ ->
                val item = etItem.text.toString()
                val des = etDescription.text.toString()
                Toast.makeText(mainActivity, "Add Data", Toast.LENGTH_SHORT).show()
                userList.add(UserData("Name:$item", "Description:$des"))
                userAdapter.notifyDataSetChanged()
                dialog.dismiss()

            }

            addDialog.setNegativeButton("Cancel") { dialog, _ ->
                Toast.makeText(mainActivity, "Cancel", Toast.LENGTH_SHORT).show()


            }
            addDialog.show()



        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun editClicked(userData: UserData) {


    }

    override fun deleteClicked(position: UserData) {
        userList.removeAt(position)

    }
}