import numpy as np


# Class to handle string valued items and keep track of metrics in a matrix
class MetricItem:

    def __init__(self, num_labels, metric_name):
        self.class_id = 0
        self.class_id_to_class_name = {}
        self.class_name_to_class_id = {}
        self.metric_matrix = None  # row-expected, col-predicted
        self.prediction_count = 0
        self.accuracy_count = 0
        self.num_classes = num_labels
        self.metric_matrix = [[0] * (num_labels + 1) for i in range(num_labels)]
        self.precision = ["NA"] * num_labels
        self.recall = ["NA"] * num_labels
        self.f1score = ["NA"] * num_labels
        self.metric_name = metric_name
        # last column is to store totals

    def insert_new_item_name(self, item_name):
        if item_name not in self.class_name_to_class_id:
            self.class_name_to_class_id[item_name] = self.class_id
            self.class_id_to_class_name[self.class_id] = item_name
            self.class_id += 1

    def update_entry(self, expected_item_name, predicted_item_name):
        if expected_item_name not in self.class_name_to_class_id:
            self.insert_new_item_name(expected_item_name)
        if predicted_item_name not in self.class_name_to_class_id:
            self.insert_new_item_name(predicted_item_name)

        expected_item_id = self.class_name_to_class_id.get(expected_item_name)
        predicted_item_id = self.class_name_to_class_id.get(predicted_item_name)

        self.metric_matrix[expected_item_id][predicted_item_id] += 1
        self.prediction_count += 1

    def compute_row_col_totals(self):
        mat = np.matrix(self.metric_matrix)
        self.metric_matrix.append((mat.sum(axis=0)).tolist()[0])
        for i in range(self.num_classes):
            self.metric_matrix[i][self.num_classes] = sum(
                self.metric_matrix[i][:self.num_classes])

    def compute_precision_recall_f1score(self):
        for i in range(self.num_classes):
            tp = self.metric_matrix[i][i]
            deno = self.metric_matrix[self.num_classes][i]
            if deno > 0:
                self.precision[i] = tp / deno

            deno = self.metric_matrix[i][self.num_classes]
            if deno > 0:
                self.recall[i] = tp / deno

            if self.precision[i] != "NA" and self.recall[i] != "NA":
                self.f1score[i] = 2 * self.precision[i] * self.recall[i] / (self.precision[i] + self.recall[i])

            self.accuracy_count += tp

    def compute_accuracy(self):
        self.accuracy = self.accuracy_count / self.prediction_count if self.prediction_count != 0 else "NA"

    def compute_all_metrics(self):
        self.compute_row_col_totals()
        self.compute_precision_recall_f1score()
        self.compute_accuracy()

    def print_all_metrics(self):
        print()
        print(self.metric_name)
        print("----------------")
        print("Class Ids:", self.class_name_to_class_id)
        print("Confusion_matrix:")
        for i in range(len(self.metric_matrix)):
            print(self.metric_matrix[i])
        print("Precision:", self.precision)
        print("Recall:", self.recall)
        print("F1-score:", self.f1score)
        print("Accuracy:", self.accuracy)
        print("Entries:", self.prediction_count)

    def get_json_output_metrics(self):
        json_obj = {"metric_name": self.metric_name, "class_ids": self.class_name_to_class_id,
                    "ids_to_class": self.class_id_to_class_name, "confusion_matrix": self.metric_matrix,
                    "precision": self.precision, "recall": self.recall, "f1_score": self.f1score,
                    "accuracy": self.accuracy, "entry_count": self.prediction_count}
        return json_obj


"""
mi = metricItem(3)
mi.update_entry("A", "A")
mi.update_entry("A", "B")
mi.update_entry("C", "C")
mi.compute_all_metrics()
mi.print_all_metrics()
"""
