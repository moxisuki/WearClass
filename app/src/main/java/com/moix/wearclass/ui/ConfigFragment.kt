package com.moix.wearclass.ui

import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.moix.wearclass.R
import com.moix.wearclass.WearApplication
import com.moix.wearclass.data.AppRepository
import com.moix.wearclass.data.AppViewModel
import com.moix.wearclass.data.LessonEntity
import com.moix.wearclass.databinding.FragmentConfigBinding
import com.moix.wearclass.util.LessonUtils

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ConfigFragment(val appViewModel: AppViewModel) : Fragment() {

    private var _binding: FragmentConfigBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentConfigBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        appViewModel.getAllLessons().observe(viewLifecycleOwner) { list ->
            list.forEach { _ ->
                Log.d(WearApplication.TAG, "onViewCreated: $list")
            }
        }
        binding.buttonSecond.setOnClickListener{
            Thread {
                Log.d(WearApplication.TAG, "onCreate: Clicked")
                val todo = LessonEntity(0, 2 , 1, 2, "test", "101", "Li", "Beijing")
                appViewModel.insert(todo)
                LessonUtils.isInLesson(todo)
            }.start()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}