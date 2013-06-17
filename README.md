
TreeMap component
-----------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/jtreemap](http://artifacts.griffon-framework.org/plugin/jtreemap)


[JTreeMap][1] is an open-source library that graphically represents a hierarchical structure. Typically, the hierarchy will involve a
tree of nodes of different sizes and different colours. 

This plugin was created by the [Hackergarten][2] programming group, at the [Canoo Engineering AG][3] world headquarters in Basel Switzerland.

Usage
-----

The following nodes will become available on a View script upon installing this plugin

| *Node*  | *Type*                           |
| ------- | -------------------------------- |
| treeMap | `net.sf.jtreemap.swing.JTreeMap` |

You can use the treemap node in views as shown in the following example.

__View__

        application(title: 'JTreeMap demo',
          pack:true,
          locationByPlatform:true,
          iconImage: imageIcon('/griffon-icon-48x48.png').image,
          iconImages: [imageIcon('/griffon-icon-48x48.png').image,
                       imageIcon('/griffon-icon-32x32.png').image,
                       imageIcon('/griffon-icon-16x16.png').image]) {
            borderLayout()
            button(text: 'Select Directory', constraints: NORTH, actionPerformed: controller.chooseFile)
            treemap(id: 'hackergartenTreeMap', constraints: CENTER)
        }

You can then reference the treemap node from your controller and set the tree nodes.

__Controller__

        import net.sf.jtreemap.swing.JTreeMap
        import net.sf.jtreemap.swing.TreeMapNode
        import net.sf.jtreemap.swing.TreeMapNodeBuilder
        import net.sf.jtreemap.swing.ValuePercent

        class SampleController {
            def view

            def chooseFile = {
                TreeMapNode root = null

                TreeMapNodeBuilder builder = new TreeMapNodeBuilder()

                TreeMapNode continentEurope = builder.buildBranch("Europe", null)
                TreeMapNode countryCH = builder.buildBranch("Switzerland", continentEurope)

                builder.buildLeaf("Basel", 120, new ValuePercent(120 / 110), countryCH)
                builder.buildLeaf("Zuerich", 200, new ValuePercent(200 / 240), countryCH)

                TreeMapNode countryDE = builder.buildBranch("Germany", continentEurope)
                builder.buildLeaf("Bayern", 300, new ValuePercent(300 / 200), countryDE)

                root = builder.root

                execInsideUISync {
                    view.hackergartenTreeMap.root = root
                }
            }
        }

[1]: http://jtreemap.sourceforge.net/
[2]: http://www.hackergarten.net/
[3]: http://www.canoo.com/

