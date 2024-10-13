/*
package com.graceful1372.space

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.graceful1372.space.databinding.FragmentMainBinding

import io.github.sceneview.math.Position
import io.github.sceneview.math.Rotation
import io.github.sceneview.node.ModelNode
import io.github.sceneview.node.ViewNode
import kotlinx.coroutines.launch


class MainFragment : Fragment() {
    //Binding
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    //Other


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //InitViews
        binding.apply {
            lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {

                }

                lifecycleScope.launchWhenCreated {

//                    sceneView.materialLoader.loadMaterial("environments/studio_small_09_2k.hdr")
//                    sceneView.environmentLoader.loadHDREnvironment("environments/studio_small_09_2k.hdr")
//
//
//                    val model = sceneView.modelLoader.loadModelInstance("models/earth.glb")!!
//                    val modelNode = ModelNode(model, true).apply {
//                        transform(
//                            position = Position(z = -4.0f),
//                            rotation = Rotation(x = 15.0f)
//                        )
//                        scaleToUnitCube(2.0f)
//                        playingAnimations
//                    }
//                    sceneView.addChildNode(modelNode)

                }
            }
        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}*/
