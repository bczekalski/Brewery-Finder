import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import store from '../store/index'
import RegisterBrewer from '../views/RegisterBrewer.vue'
import BreweriesDisplay from '../views/BreweriesDisplay.vue'
import BreweryDisplay from '../views/BreweryDisplay.vue'
import BeersDisplay from '../views/BeersDisplay.vue'
import BeerDisplay from '../views/BeerDisplay.vue'
import BreweryReviewDisplay from '../views/BreweryReviewDisplay'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register-brewer",
      name: "register-brewer",
      component: RegisterBrewer,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/breweries",
      name: "breweries-display",
      component: BreweriesDisplay,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/breweries/:breweryId",
      name: "brewery-display",
      component: BreweryDisplay,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/breweries/:breweryId/beers',
      name: 'beers-display',
      component: BeersDisplay,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/breweries/:breweryId/beers/:beerId',
      name: 'beer-display',
      component: BeerDisplay,
      meta: {
        requiresAuth: false
      } 
    },
    {
      path: '/breweries/:breweryId/reviews',
      name: 'brewery-review-display',
      component: BreweryReviewDisplay,
      meta: {
        requiresAuth: false
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;
