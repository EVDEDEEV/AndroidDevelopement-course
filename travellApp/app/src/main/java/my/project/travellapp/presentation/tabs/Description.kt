package my.project.travellapp.presentation.tabs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import my.project.travellapp.R
import my.project.travellapp.databinding.DescriptionBinding
import my.project.travellapp.databinding.TourListBinding


class Description : Fragment() {

    private var binding: DescriptionBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.description, container, false)

        return binding?.root
    }

}