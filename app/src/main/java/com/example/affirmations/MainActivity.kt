package com.example.affirmations
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.affirmations.data.Datasource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize data.
        val myDataset = Datasource().loadAffirmations()

        val listView = findViewById<ListView>(R.id.list_view)
        listView.adapter = GmailListAdapter(listOf(
            GmailItem(1, "Clark Lopez", "Lorem ipsum dolor sit amet, consectetur adipiscing elit.", "12: 34 PM"),
            GmailItem(2, "Keller Quinn", "The quick brown fox jumps over the lazy dog.", "12: 34 PM"),
            GmailItem(3, "Peter Morgan", "Random text example.", "12: 34 PM"),
            GmailItem(4, "Liam Irwin", "Hello, this is a sample text.", "12: 34 PM"),
            GmailItem(5, "Rachel Brown", "How much wood would a woodchuck chuck if a woodchuck could chuck wood?", "12: 34 PM"),
            GmailItem(6, "Mia Ng", "You miss 100% of the shots you don't take.", "12: 34 PM"),
            GmailItem(7, "Tina Owens", "That's one small step for man, one giant leap for mankind.", "12: 34 PM"),
            GmailItem(8, "Fiona Owens", "That's one small step for man, one giant leap for mankind.", "12: 34 PM"),
            GmailItem(9, "George Fisher", "That's one small step for man, one giant leap for mankind.", "12: 34 PM"),
            GmailItem(10, "Bob Evans", "That's one small step for man, one giant leap for mankind.", "12: 34 PM"),
            GmailItem(11, "Tina Owens", "That's one small step for man, one giant leap for mankind.", "12: 34 PM"),
            GmailItem(12, "Diana Davis", "That's one small step for man, one giant leap for mankind.", "12: 34 PM"),
        ))
    }
}

data class GmailItem(
    val id: Int,
    val title: String,
    val content: String,
    val time: String
)

private class GmailListAdapter(
    val listGmail: List<GmailItem>
) : BaseAdapter() {
    override fun getCount() = listGmail.size

    override fun getItem(position: Int) = listGmail[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, container: ViewGroup): View {
        var view: View? = convertView
        if (view == null) {
            view = LayoutInflater.from(container.context).inflate(R.layout.list_item, container, false)
        }

        val itemView: View = view as View
        itemView.findViewById<TextView>(R.id.name)?.text = getItem(position).title[0].toString().uppercase()
        itemView.findViewById<TextView>(R.id.title)?.text = getItem(position).title
        itemView.findViewById<TextView>(R.id.time)?.text = getItem(position).time
        itemView.findViewById<TextView>(R.id.content)?.text = getItem(position).content

        return itemView
    }
}