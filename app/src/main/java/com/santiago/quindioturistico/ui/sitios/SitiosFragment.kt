package com.santiago.quindioturistico.ui.sitios

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.santiago.quindioturistico.MenuActivity
import com.santiago.quindioturistico.R
import com.santiago.quindioturistico.databinding.FragmentSitiosBinding
import com.santiago.quindioturistico.ui.MainAdapter

import kotlinx.android.synthetic.main.fragment_sitios.*

class SitiosFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private  var SitiosViewModel: SitiosViewModel = SitiosViewModel()
    private var _binding: FragmentSitiosBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        SitiosViewModel =
            ViewModelProvider(this).get(SitiosViewModel::class.java)

        _binding = FragmentSitiosBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        
        text_sitios.text = "This is Sitios Fragment"

        setupRecyclerView()


    }


    private fun setupRecyclerView(){
        recyclerViewSitios.layoutManager =  LinearLayoutManager(requireContext())
        val adapter = MainAdapter(MenuActivity.listaSitios)
        recyclerViewSitios.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    fun infoCSV(){
        val openRawResource = resources.openRawResource(R.raw.sitios)
        val bufferedReader = openRawResource.bufferedReader()
        var line = bufferedReader.readLine()
        while (line!= null){
            text_sitios.text =  line
            line =  bufferedReader.readLine()
        }
    }
}