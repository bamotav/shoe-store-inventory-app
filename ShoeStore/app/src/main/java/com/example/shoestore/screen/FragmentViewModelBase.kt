//package com.example.shoestore.screen
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.annotation.LayoutRes
//import androidx.databinding.DataBindingUtil
//import androidx.databinding.ViewDataBinding
//import androidx.fragment.app.Fragment
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import kotlin.reflect.KClass
//import kotlin.reflect.KMutableProperty
//import kotlin.reflect.KProperty
//import kotlin.reflect.full.memberProperties
//
//open class FragmentViewModelBase<VM: ViewModel> (@LayoutRes  val layout: Int, private val dataBindingName: String, private val viewModelClass: Class<VM> /*private val clazz: Class<T>*/) :
//    Fragment()
// {
//
//     open var binding: ViewDataBinding? = null
//     open lateinit var viewModel: VM
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//        binding = DataBindingUtil.inflate(inflater, layout, container, false)
//        binding?.lifecycleOwner = viewLifecycleOwner
//        viewModel = ViewModelProvider(requireActivity()).get(viewModelClass)//getViewModel(viewModelClass)
//        //If binding available, return it's root otherwise just inflate normally, binding stays null
//        return binding?.root ?: inflater.inflate(layout, container, false)
//
////        val binding : V = DataBindingUtil.inflate(inflater, layoutId, container, false)
////
////        _viewModel = ViewModelProvider(requireActivity()).get(clazz)
////        _binding = binding
////
////        val propertyToChangeValue = binding::class.memberProperties.associateBy(KProperty<*>::name)
////
////        propertyToChangeValue[dataBindingName]
////            .takeIf { it is KMutableProperty<*> }
////            ?.let { it as KMutableProperty<*> }
////            ?.let { it.setter.call(binding, _viewModel) }
////
////        binding.lifecycleOwner = this
////
////        return binding.root
//
//    }
//
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val propertyToChangeValue = this.binding!!::class.memberProperties.associateBy(KProperty<*>::name)
//
//        propertyToChangeValue[dataBindingName]
//            .takeIf { it is KMutableProperty<*> }
//            ?.let { it as KMutableProperty<*> }
//            ?.let { it.setter.call(binding, viewModel) }
//
//    }
//     inline fun <reified specific : ViewDataBinding> getSpecificBinding() = binding as? specific
//}
//
