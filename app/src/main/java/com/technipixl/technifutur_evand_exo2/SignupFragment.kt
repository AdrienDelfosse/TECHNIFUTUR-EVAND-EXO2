package com.technipixl.technifutur_evand_exo2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import com.technipixl.technifutur_evand_exo2.databinding.FragmentBloggiesBinding
import com.technipixl.technifutur_evand_exo2.databinding.FragmentSignupBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var binding: FragmentSignupBinding? =null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupBinding.inflate(inflater, container, false)

        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.loginButton?.setOnClickListener {
            val builder: AlertDialog.Builder? = activity?.let {
                AlertDialog.Builder(it)
            }

            if(binding?.emailEditText?.text?.isEmpty()==true || binding?.emailEditText?.text?.contains("@") == false){
                builder?.setMessage("L'email est invalide")
                    ?.setTitle("Erreur")
                builder?.show()

            }else if(binding?.loginEditText?.text?.isEmpty()==true){
                builder?.setMessage("Le login n'a pas été rempli.")
                    ?.setTitle("Erreur")
                builder?.show()
            }else if(binding?.confirmationEditText?.text?.equals( binding?.passwordEditText?.text)==false && binding?.confirmationEditText?.text?.isEmpty() == true){
                builder?.setMessage("Les mots de passe ne correspondent pas")
                    ?.setTitle("Erreur")
                builder?.show()
            }else{
                findNavController().navigate(SignupFragmentDirections.actionSignupFragmentToAfterLoginFragment())
            }

        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SignupFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SignupFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}