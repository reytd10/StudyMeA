package studymeteam.studymea;

import android.content.Intent;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.LinkedHashMap;



public class TestsTab extends Fragment {
    private LinkedHashMap<String, GroupInfo> subjects = new LinkedHashMap<String, GroupInfo>();
    private ArrayList<GroupInfo> deptList = new ArrayList<GroupInfo>();

    private CustomAdapter listAdapter;
    private ExpandableListView simpleExpandableListView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View RootView = inflater.inflate(R.layout.fragment_tests_tab, container, false);

        // add data for displaying in expandable list view
        loadData();

        //get reference of the ExpandableListView
        simpleExpandableListView = (ExpandableListView) RootView.findViewById(R.id.expList1);
        // create the adapter by passing your ArrayList data
        listAdapter = new CustomAdapter(getContext(), deptList);
        // attach the adapter to the expandable list view
        simpleExpandableListView.setAdapter(listAdapter);

        //expand all the Groups
        collapseAll();

        simpleExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                ///Go To Weekly Tests
                if(groupPosition == 0) {
                    //get the group header
                    GroupInfo headerInfo = deptList.get(0);
                    //get the child info
                    ChildInfo detailInfo = headerInfo.getProductList().get(childPosition);
                    //display it or do something with it
                    Intent intent = new Intent(getActivity(), TestPage.class);
                    startActivity(intent);

                }
                ///Go To Monthly Tests
                if(groupPosition == 1) {
                    //get the group header
                    GroupInfo headerInfo = deptList.get(1);
                    //get the child info
                    ChildInfo detailInfo = headerInfo.getProductList().get(childPosition);
                    //display it or do something with it
                    Toast.makeText(getContext(), "Coming in the Future", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });
        // setOnGroupClickListener listener for group heading click
        simpleExpandableListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                //get the group header
                GroupInfo headerInfo = deptList.get(groupPosition);
                //display it or do something with it

                return false;
            }
        });
        return RootView;
    }



    //method to expand all groups
    private void expandAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.expandGroup(i);
        }
    }

    //method to collapse all groups
    private void collapseAll() {
        int count = listAdapter.getGroupCount();
        for (int i = 0; i < count; i++){
            simpleExpandableListView.collapseGroup(i);
        }
    }


    //load some initial data into out list
    private void loadData(){
        ///Load the available test to the Tab
        ///If the Test is not unlocked yet ( a data in the database will determine this)
        //Then the Test will not be added.
        addProduct("WeeklyTest","Week 1");
        addProduct("WeeklyTest","Week 2");
        addProduct("WeeklyTest","Week 3");

        addProduct("MonthlyTest","1st Month");
        addProduct("MonthlyTest","2nd Month");

    }


    //here we maintain our products in various departments
    private int addProduct(String department, String product){

        int groupPosition = 0;

        //check the hash map if the group already exists
        GroupInfo headerInfo = subjects.get(department);
        //add the group if doesn't exists
        if(headerInfo == null){
            headerInfo = new GroupInfo();
            headerInfo.setName(department);
            subjects.put(department, headerInfo);
            deptList.add(headerInfo);
        }

        //get the children for the group
        ArrayList<ChildInfo> productList = headerInfo.getProductList();
        //size of the children list
        int listSize = productList.size();
        //add to the counter
        listSize++;

        //create a new child and add that to the group
        ChildInfo detailInfo = new ChildInfo();
        detailInfo.setSequence(String.valueOf(listSize));
        detailInfo.setName(product);
        productList.add(detailInfo);
        headerInfo.setProductList(productList);

        //find the group position inside the list
        groupPosition = deptList.indexOf(headerInfo);
        return groupPosition;
    }




}

