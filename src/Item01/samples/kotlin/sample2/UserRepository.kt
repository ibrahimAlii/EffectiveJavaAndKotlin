package Item01.samples.kotlin.sample2

interface UserRepository {
    fun getUser(): User

    companion object : Provider<UserRepository>() {
        override fun create() = UserRepositoryImpl()
    }
}

/*
  With such definitions, I can get this repository by UserReposiroty.get() or lazily by val user by UserRepository.lazyGet()
  all around the code.
  I can also specify different implementation for testing or mocking purposes by
  UserRepository.mocked = object: UserRepository { /*...*/ }.
 */