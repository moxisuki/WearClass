package com.moix.wearclass.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.moix.wearclass.R
import com.moix.wearclass.data.TableList
import com.moix.wearclass.databinding.FragmentTableBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TableFragment : Fragment() {

    private var _binding: FragmentTableBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTableBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val data = mutableListOf<TableList>()
        data.add(TableList("语文","早读","C204","朱老师","7:05-7:37"))
        data.add(TableList("数学","早读","C204","朱老师","7:05-7:37"))
        data.add(TableList("数学","早读","C204","朱老师","7:05-7:37"))
        data.add(TableList("数学","早读","C204","朱老师","7:05-7:37"))
        data.add(TableList("数学","早读","C204","朱老师","7:05-7:37"))
        data.add(TableList("数学","早读","C204","朱老师","7:05-7:37"))
        data.add(TableList("数学","早读","C204","朱老师","7:05-7:37"))
        //使用Recycler
        val layoutManager = LinearLayoutManager(view.context)
        val recyclerView: RecyclerView = binding.mRecycler
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        val adapter = TableAdapter(data)
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}