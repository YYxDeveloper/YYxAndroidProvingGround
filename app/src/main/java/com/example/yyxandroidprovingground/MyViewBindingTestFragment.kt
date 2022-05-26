package com.example.yyxandroidprovingground

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.yyxandroidprovingground.databinding.FragmentMyViewBindingTestBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyViewBindingTestFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyViewBindingTestFragment : Fragment() {

    private var _binding: FragmentMyViewBindingTestBinding? = null
    private  val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        _binding = FragmentHomeBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//        val textView: TextView = binding.textHome

        _binding = FragmentMyViewBindingTestBinding.inflate(inflater, container, false)
        val rootView: View = binding.root
        val btn: Button = binding.theButton


        return inflater.inflate(R.layout.fragment_my_view_binding_test, container, false)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyViewBindingTestFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyViewBindingTestFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}