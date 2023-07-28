package com.example.common.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.common.task.TaskModel
import com.example.common.task.domain.TaskDataSource
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TaskViewModel(
    private val taskDataSource: TaskDataSource
) : ViewModel() {

    var taskId: MutableState<Long> = mutableStateOf(0L)

    var taskState: MutableState<TaskState> = mutableStateOf(TaskState.NONE)

    var mainTaskState: MutableState<TaskState> = mutableStateOf(TaskState.NONE)

    var task: MutableState<TaskModel> = mutableStateOf(TaskModel(id = 0L, title = "", message = ""))

    fun conductOperationsOnTask() {
        when (mainTaskState.value) {
            TaskState.ADD_TASK -> insertTask(task.value.copy(id = null))
            TaskState.UPDATE_TASK -> insertTask(task.value)
            TaskState.DELETE_TASK -> deleteTask(task.value.id ?: 0)
            TaskState.NONE -> {}
        }

        mainTaskState.value = TaskState.NONE
    }

    private var _allTasks = MutableStateFlow<List<TaskModel>>(listOf())
    val allTasks: StateFlow<List<TaskModel>> = _allTasks

    fun getAllTasks() {
        viewModelScope.launch {

            try {
                taskDataSource.getTasks().collect { tasks ->

                    _allTasks.value = tasks

                }
            } catch (e: Exception) {
                _allTasks.value = listOf()
            }

        }
    }

    private fun insertTask(
        taskModel: TaskModel
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDataSource.insertTask(taskModel)
        }
    }

    private fun deleteTask(
        id: Long
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDataSource.deleteTask(id)
        }
    }

}