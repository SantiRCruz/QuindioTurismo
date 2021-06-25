package com.santiago.quindioturistico.ui.hoteles

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.santiago.quindioturistico.databinding.FragmentHotelesBinding

class HotelesFragment : Fragment() {

    private lateinit var HotelesViewModel: HotelesViewModel
    private var _binding: FragmentHotelesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        HotelesViewModel =
            ViewModelProvider(this).get(HotelesViewModel::class.java)

        _binding = FragmentHotelesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        HotelesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}