<template>
    <div>
        <div class="card card-default">
            <div class="card-header">
                <div class="float-left">
                    Última actividad en Wikipedia (/api/latest_wiki_entries)
                </div>
                <div class="float-right">
                    <button type="button" class="btn btn-primary" v-on:click="getEntries"><span class="glyphicon glyphicon-refresh"></span> Actualizar</button>
                </div>
            </div>

            <div class="card-body" style="padding:0rem;">
                <!-- Loading entries -->
                <p class="mb-0" v-if="entries.length === 0" style="padding:1.25rem;">
                    Cargando datos...
                </p>

                <!-- Wikipedia entries Tokens -->
                <table class="table table-striped table-hover mb-0" v-if="entries.length > 0">
                    <thead>
                        <tr>
                            <th width=15%>Evento</th>
                            <th width=35%>Cosa</th>
                            <th width=20%>Usuario</th>
                            <th width=30%>Enlace</th>
                        </tr>
                    </thead>

                    <tbody>
                        <tr v-for="entry in entries">
                            <!-- Client Name -->
                            <td style="vertical-align: middle;">
                                {{ entry.event }}
                            </td>
                            <td style="vertical-align: middle;">
                                {{ entry.item }}
                            </td>
                            <td style="vertical-align: middle;">
                                {{ entry.username }}
                            </td>
                            <td style="vertical-align: middle;">
                                {{ entry.link }}
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        /*
         * The component's data.
         */
        data() {
            return {
                entries: [],
            };
        },

        /**
         * Prepare the component (Vue 1.x).
         */
        ready() {
            this.prepareComponent();
        },

        /**
         * Prepare the component (Vue 2.x).
         */
        mounted() {
            this.prepareComponent();
        },
        methods: {
            /**
             * Prepare the component.
             */
            prepareComponent() {
                this.getEntries();
            },

            /**
             * Get all of the personal access tokens for the user.
             */
            getEntries() {
                axios.get('api/latest_wiki_entries')
                        .then(response => {
                            this.entries = response.data.slice(0,10);
                        });
            },
        }
    }
</script>
