Rails.application.routes.draw do
  get '' => 'displays#index'
  get 'hello' => 'displays#hello'
  get 'say/hello' => 'displays#say'
  get 'say/hello(/:name)' => 'displays#say'
  get 'times' => 'displays#visit'
  get 'reset' => 'displays#restart'
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
end
