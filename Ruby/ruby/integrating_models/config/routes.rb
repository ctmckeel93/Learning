Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  # root '' => 'user#index'
  get 'users' => 'user#user_api'
  get 'users/new' => 'user#new_user'
  get 'users/total' => 'user#total'
  get 'users/:id' => 'user#user_info'
  get 'users/:id/edit' => 'user#edit'
  post 'users/create' => 'user#create'


end
