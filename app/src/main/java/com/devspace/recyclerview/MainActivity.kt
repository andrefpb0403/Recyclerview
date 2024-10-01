package com.devspace.recyclerview

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Criar o adapter
        // Set Adapter
        // LinearLayout Manager
        // Submeter a lista
        // Grid Layout Manager com ação em dois image views
        // Adição da ação de clique nos itens da lista


        val rvList = findViewById<RecyclerView>(R.id.rv_list)
        val ivList = findViewById<ImageView>(R.id.iv_list)
        val ivGrid = findViewById<ImageView>(R.id.iv_grid)
        val adapter = ContactListAdapter()

        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        adapter.submitList(contacts)


        ivGrid.setOnClickListener {
            rvList.layoutManager = GridLayoutManager(this, 2)
        }
        ivList.setOnClickListener {
            rvList.layoutManager = LinearLayoutManager(this)
        }
        adapter.setOnclickListener { contact ->
            val intent = Intent(this, ContactDetailActivity::class.java)
            intent.putExtra("name", contact.name)
            intent.putExtra("phone", contact.phone)
            intent.putExtra("icon", contact.avatar)
            startActivity(intent)
        }
    }
}

private val contacts = listOf(
    Contact(
        name = "Roque",
        phone = "(55)11 98756-7584",
        avatar = R.drawable.sample2
    ),
    Contact(
        name = "Bruna",
        phone = "(55)11 92256-7444",
        avatar = R.drawable.sample1
    ),
    Contact(
        name = "Brenda",
        phone = "(55)11 92356-7384",
        avatar = R.drawable.sample3
    ),
    Contact(
        name = "Julia",
        phone = "(55)11 98326-7464",
        avatar = R.drawable.sample4
    ),
    Contact(
        name = "Camila",
        phone = "(55)11 99756-3384",
        avatar = R.drawable.sample5
    ),
    Contact(
        name = "Francisco",
        phone = "(55)11 99336-2284",
        avatar = R.drawable.sample8
    ),
    Contact(
        name = "Erick",
        phone = "(55)11 99116-1184",
        avatar = R.drawable.sample9
    ),
    Contact(
        name = "Joao",
        phone = "(55)11 99236-1135",
        avatar = R.drawable.sample10
    ),
    Contact(
        name = "Helena",
        phone = "(55)11 99216-1235",
        avatar = R.drawable.sample11
    ),
    Contact(
        name = "Jose",
        phone = "(55)11 92356-1284",
        avatar = R.drawable.sample12
    ),
    Contact(
        name = "Maria",
        phone = "(55)11 99226-3384",
        avatar = R.drawable.sample13
    ),
    Contact(
        name = "Enzo",
        phone = "(55)11 99336-1974",
        avatar = R.drawable.sample14
    ),
    Contact(
        name = "Laura",
        phone = "(55)11 99212-2135",
        avatar = R.drawable.sample15
    ),
    Contact(
        name = "Gabi",
        phone = "(55)11 99217-1234",
        avatar = R.drawable.sample16
    ),

    )
