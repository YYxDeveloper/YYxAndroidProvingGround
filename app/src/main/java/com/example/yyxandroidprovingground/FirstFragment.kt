package com.example.yyxandroidprovingground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.yyxandroidprovingground.databinding.FragmentFirstBinding
import kotlinx.coroutines.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    private  val  firstViewModel by viewModels<FirstViewModel> ()
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textviewFirst
        val  btn: Button = binding.buttonFirst
//        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        binding.buttonFirst.apply {

        }

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
//        firstViewModel.practiseCoroutine()
//            firstViewModel.job
        GlobalScope.launch(Dispatchers.Main) {
            firstViewModel.practiseCoroutine3()
            println("yyxxxx 45678")
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}