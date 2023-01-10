package food.com.br.appfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import food.com.br.appfood.R;
import food.com.br.appfood.databinding.ActivityMainBinding;
import food.com.br.appfood.ui.cart.CartFragment;
import food.com.br.appfood.ui.favorites.FavoritesFragment;
import food.com.br.appfood.ui.home.HomeFragment;
import food.com.br.appfood.ui.user.UserFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.menu_home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.menu_favorites:
                    replaceFragment(new FavoritesFragment());
                    break;
                case R.id.menu_cart:
                    replaceFragment(new CartFragment());
                    break;
                case R.id.menu_user:
                    replaceFragment(new UserFragment());
                    break;
            }
            return true;
        });

    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}